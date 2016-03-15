(ns slacktrax.stats)

(defn count-comparator
  [a b]
  (> (count a) (count b)))

(defn get-most-reacted-messages
  "returns messages sorted by most reactions"
  [messages]
  (sort-by :reactions count-comparator messages))

(defn get-most-starred-messages
  "returns messages sorted by most reactions"
  [messages]
  (sort-by :stars count-comparator messages))

(defn gather-stats
  "gather stats about all messages"
  [messages]
    (let [most-starred (get-most-starred-messages messages)
          most-reacted (get-most-reacted-messages messages)]
      {:most-reacted most-reacted
       :most-starred most-starred}))

