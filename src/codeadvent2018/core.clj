(ns codeadvent2018.core
  (:gen-class)
  (:require [codeadvent2018.day01 :as d01])
  (:require [codeadvent2018.day02 :as d02])
  (:require [codeadvent2018.day03 :as d03])
  (:require [codeadvent2018.day04 :as d04])
  (:require [codeadvent2018.day05 :as d05])
  (:require [codeadvent2018.day06 :as d06])
  (:require [codeadvent2018.day07 :as d07])
  (:require [codeadvent2018.day08 :as d08])
  (:require [codeadvent2018.day09 :as d09])
  (:require [codeadvent2018.day10 :as d10])
  (:require [codeadvent2018.day11 :as d11])
  (:require [codeadvent2018.day12 :as d12])
  (:require [codeadvent2018.day13 :as d13])
  (:require [codeadvent2018.day14 :as d14])
  (:require [codeadvent2018.day16 :as d16])
  (:require [codeadvent2018.day17 :as d17])
  (:require [codeadvent2018.day18 :as d18])
  (:require [codeadvent2018.day19 :as d19])
  (:require [codeadvent2018.day20 :as d20])
  (:require [codeadvent2018.day21 :as d21])
  (:require [codeadvent2018.day22 :as d22])
  (:require [codeadvent2018.day23 :as d23])
  (:require [codeadvent2018.day24 :as d24])
  (:require [codeadvent2018.day25 :as d25])
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

