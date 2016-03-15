(ns slacktrax.lib.datetime
  "Useful date/time utilities"
  (:require [clj-time.core :as t]))

(def timemap {"days" t/days
              "weeks" t/weeks
              "months" t/months
              "years" t/years})

(defn map-string-to-time
  "Get a clj-time representation of a string interval"
  [timestr]
  (get timemap timestr))

(defn time-ago
  "get the DateTime representation of the `val` `time-unit` ago (e.g., 7 days ago => `(time-ago 7 t/days)`)"
  [val time-unit]
  (-> (read-string val)
      time-unit
      t/ago))

(defn datetime-to-epoch-interval
  "get interval representing the difference between epoch time and `datetime`"
  [datetime]
  (t/interval (t/epoch) datetime))

(defn datetime-epoch-interval-in-seconds
  "get difference in seconds between epoch time and `val` in `time-unit`"
  [val time-unit]
  (let [timeago (time-ago val time-unit)
        timeago-epoch-interval (datetime-to-epoch-interval timeago)
        timeago-epoch (t/in-seconds timeago-epoch-interval)]
    timeago-epoch))
