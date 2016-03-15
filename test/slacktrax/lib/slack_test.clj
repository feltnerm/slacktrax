(ns slacktrax.lib.slack-test
  (:require [slacktrax.lib.slack :as slack]
            [clojure.test :refer :all]))

;; (def channel {:creator "U02G3MJJB",
;;               :purpose
;;               {:value "WIP Team Discussions",
;;                :creator "U02G3MJJB",
;;                :last_set 1454605255},
;;               :num_members 5,
;;               :is_channel true,
;;               :name "wip",
;;               :is_member true,
;;               :is_archived false,
;;               :created 1454605255,
;;               :topic {:value "", :creator "", :last_set 0},
;;               :id "C0L9VCCJK",
;;               :members
;;               ["U02G36WG5" "U02G3MJJB" "U02GUJY2L" "U0HLLE2P3" "U0HLPU0HW"],
;;               :is_general false})

(deftest test-get-channel-by-name
  (testing "get-channel-by-name"
    (is (= 1 1))))
