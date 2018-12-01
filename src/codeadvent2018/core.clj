(ns codeadvent2018.core
  (:gen-class)
  (:require [codeadvent2018.day01 :as d01])
  )

(def day->runnerfunc
  (into {}
        (map #(vector % (-> "d%02d/run"
                      (format %)
                      symbol
                      resolve))
             (range 1 26))))


(defn run-exercise [day]
  (let [input (format "resources/day%02d.txt" day)
        func (get day->runnerfunc day)
        lines (clojure.string/split-lines (slurp input))]
        (func lines)))


(defn -main [day & args]
  (run-exercise (Integer/parseInt day)))

