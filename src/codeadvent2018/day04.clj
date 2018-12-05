(ns codeadvent2018.day04)


(def data ["[1518-09-28 00:56] wakes up" "[1518-10-15 00:05] falls asleep" "[1518-02-15 00:58] wakes up" "[1518-08-26 00:51] wakes up" "[1518-03-23 00:32] wakes up" "[1518-05-04 23:56] Guard #523 begins shift" "[1518-07-28 00:55] wakes up" "[1518-02-08 00:49] wakes up" "[1518-04-20 00:02] Guard #2017 begins shift" "[1518-09-12 00:57] wakes up" "[1518-06-11 00:34] wakes up" "[1518-06-08 00:20] wakes up" "[1518-01-29 00:53] wakes up" "[1518-09-23 00:03] falls asleep" "[1518-02-11 00:19] falls asleep" "[1518-05-12 23:57] Guard #151 begins shift" "[1518-07-24 00:47] wakes up" "[1518-07-21 00:03] falls asleep" "[1518-05-19 00:54] wakes up" "[1518-08-21 00:52] wakes up" "[1518-10-10 00:52] wakes up" "[1518-02-02 00:14] wakes up" "[1518-10-15 00:52] wakes up" "[1518-03-13 23:46] Guard #2081 begins shift" "[1518-08-07 00:26] falls asleep" "[1518-08-13 00:00] Guard #349 begins shift" "[1518-10-17 00:22] falls asleep" "[1518-03-10 00:14] falls asleep" "[1518-09-30 00:48] wakes up" "[1518-07-01 23:57] Guard #3469 begins shift" "[1518-04-09 23:57] Guard #3413 begins shift" "[1518-04-28 00:35] falls asleep" "[1518-06-08 00:49] wakes up"])


(defn parse-record [r]
  (let [[year day month hour minute info]
        (rest
         (re-find #"\[([0-9]+)-([0-9]+)-([0-9]+) ([0-9]+):([0-9]+)\] \w+ ([0-9wakesup#]+)" r))]
    {:date (mapv #(Integer/parseInt %) [year day month])
     :time (mapv #(Integer/parseInt %) [hour minute])
     :wakeup (= info "up")
     :asleep (= info "asleep")
     :id (if (= (first info) \#) info)}))


(clojure.pprint/pprint
 (partition-by :id (sort-data data)))

(defn run [input]
  (println "-"))

(let [dat (map parse-record (sort data))]
  (reduce
   (fn [prev new]

     )
   {}
   dat))


(reduce
 {}
 (sort-data ))
