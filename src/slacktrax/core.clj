(ns slacktrax.core
  (:require [slacktrax.stats :as stats]
            [slacktrax.lib.slack :as slack]
            [slacktrax.lib.datetime :as datetime])
  (:gen-class
   :methods [^:static [handler [String] String]]))

;; entrypoints
(defn -main
  "Main method entrypoint"
  [& args]
  (let [slack-token         (nth args 0)
        slack-channel       (nth args 1)
        timeago-val         (nth args 2)
        timeago-interval    (nth args 3)
        timeago-interval-dt (datetime/map-string-to-time timeago-interval)
        timeago             (String/valueOf
                             (datetime/datetime-epoch-interval-in-seconds timeago-val
                                                                          timeago-interval-dt))
        connection          (slack/make-connection slack-token)
        channel-messages    (slack/channel-message-history connection slack-channel timeago)]
    (pprint/pprint (stats/gather-stats channel-messages))))

(defn test
  "Call -main with test options for REPL-driven-development"
  [args]
  (apply -main args))
