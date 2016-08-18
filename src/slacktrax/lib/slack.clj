(ns slacktrax.lib.slack
  "Functions for interacting with the Slack API"
  (:require [clj-slack.users :as users]
            [clj-slack.search :as search]
            [clj-slack.channels :as channels]))

;; slack
(defn make-connection
  "Creates an HTTP hittable URL based on authentication token"
  [token]
  {:api-url "https://slack.com/api" :token token})

;; side-effecty functions
(defn- get-all-channels
  [connection]
  (channels/list connection))

(defn- get-user-info
  "gets the user info"
  [connection id]
  (users/info connection id))

(defn- get-channel-history
  "get the messages for a channel starting at an optional `end` date"
  [connection channel-id & [end]]
  (channels/history connection
                    channel-id
                    (assoc {:oldest end})))

;; channels
(defn- get-channel-by-name
  "get the unique Slack ID for a channel name (no #)"
  [connection name]
  (let [all-chans (:channels (get-all-channels connection))
        channel   (first (filter (fn [chan] (= (:name chan) name)) all-chans))]
    channel))

(defn- get-channel-members-by-channel-name
  "get the list of current channel members"
  [connection name]
  (let [chan (get-channel-by-name connection name)
        members (:members chan)]
    members))

;; messages
(defn- get-messages-by-channel-name
  "get all the messages in a channel for a date range"
  [connection channel-name & [end]]
  (let [channel-id (:id (get-channel-by-name connection channel-name))
        messages   (channels/history connection
                                     (:id (get-channel-by-name connection channel-name))
                                     (assoc {} :oldest end))]
    (:messages messages)))

(defn channel-message-history
  "Get all the messages in a channel until `end-time`"
  [connection channel-name & [end-time]]
  (let [channel-messages          (get-messages-by-channel-name connection channel-name end-time)
        channel-members           (get-channel-members-by-channel-name connection channel-name)]
    channel-messages))
