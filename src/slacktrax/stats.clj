(ns slacktrax.stats)

(defn count-comparator
  [a b]
  (> (count a) (count b)))

(defn get-most-reacted-messages
  "Returns messages sorted by most reactions"
  [messages]
  (filter #(< 0 (count (:reactions %))) (sort-by :reactions count-comparator messages)))

;; @TODO
;; (defn get-ranked-messages-per-reaction
;;   ""
;;   [messages]
;;   (reduce #() {} messages))

(defn gather-stats
  "Gather stats about all messages"
  [messages]
    (let [most-reacted (get-most-reacted-messages messages)]
      {:most-reacted most-reacted}))

