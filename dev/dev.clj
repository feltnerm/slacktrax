(ns dev
  "Tools for interactive development with the REPL. This file should
  not be included in a production build of the application."
  (:require
   [clojure.java.io :as io]
   [clojure.java.javadoc :refer [javadoc]]
   [clojure.pprint :refer [pprint]]
   [clojure.reflect :refer [reflect]]
   [clojure.repl :refer [apropos dir doc find-doc pst source]]
   [clojure.set :as set]
   [clojure.string :as str]
   [clojure.test :as test]
   [clojure.tools.namespace.repl :refer [refresh refresh-all]]
   [slacktrax.core]
   [slacktrax.aws.lambda]
   [clojure.test :refer [run-tests]]
   [slacktrax.core-test]
   [slacktrax.lib.slack-test]
   [slacktrax.lib.datetime-test]
   ))

;; fill in for development
;; DO NOT COMMIT
(def CHANNEL_NAME "") ;; note that there is no '#'
(def TOKEN "xoxp-**********-**********-**********-******")
;; DO NOT COMMIT

(def system
  "A Var containing an object representing the application under
  development."
  nil)

(defn init
  "Creates and initializes the system under development in the Var
  #'system."
  []
  ;; TODO
  )

(defn start
  "Starts the system running, updates the Var #'system."
  []
  (let [token TOKEN
        channel-name CHANNEL_NAME
        timeago-val "7"
        timeago-interval "days"]
    (pprint (apply slacktrax.core/-main [token channel-name timeago-val timeago-interval]))))

(defn start-test
  "Starts the test system running, updates the Var #'system."
  []
  (run-tests 'slacktrax.core-test)
  (run-tests 'slacktrax.lib.slack-test)
  (run-tests 'slacktrax.lib.datetime-test))

(defn stop
  "Stops the system if it is currently running, updates the Var
  #'system."
  []
  ;; TODO
  )

(defn go
  "Initializes and starts the system running."
  []
  (init)
  (start)
  :ready)

(defn go-test
  "Initializes and starts the test-system running."
  []
  (init)
  (start-test)
  :ready)

(defn reset
  "Stops the system, reloads modified source files, and restarts it."
  []
  (stop)
  (refresh :after `go))

(defn reset-test
  "Stops the system, reloads modified source files, and restarts it."
  []
  (stop)
  (refresh :after `go-test))
