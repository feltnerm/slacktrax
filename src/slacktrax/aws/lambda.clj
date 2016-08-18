(ns slacktrax.aws.lambda
  (:require [amazonica.aws.lambda :as lambda]
            [clojure.data.json :as json]))

(defn get-function-configuration
  [function-name]
  (lambda/get-function-configuration  :function-name function-name))

(defn get-function-runtime-configuration
  "get the runtime configuraiton off the function's description (hack)"
  [function-name]
  (json/read-str (:description (get-function-configuration function-name))))
