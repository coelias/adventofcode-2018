(ns codeadvent2018.day03)

(defn parse-row [string]
  (->> string
       (re-find #"#([0-9]+) @ ([0-9]+),([0-9]+): ([0-9]+)x([0-9]+)")
       rest
       (map #(Integer/parseInt %))))

(defn pattern-tuples [[_ ypad xpad ysize xsize]]
  (frequencies
   (for [y (range ypad (+ ypad ysize))
         x (range xpad (+ xpad xsize))]
     [y x])))

(defn pattern-map [input]
  (let [parsed-input (map parse-row input)]
            (reduce
             #(merge-with + %1 %2)
             (map pattern-tuples parsed-input))))

(defn pattern-filter [pred pm]
  (into {} (filter (fn [[_ v]] (pred v)) pm)))

(defn part1 [pm]
  (->> pm
       (pattern-filter #(< 1 %))
       count))

(defn pattern-in-map? [pattern pm]
  (let [[id & more :as parsed] (parse-row pattern)]
    (if (every? #(get pm %) (keys (pattern-tuples parsed)))
      id)))

(defn part2 [pm input]
  (let [pm (pattern-filter #(= 1 %) pm)]
    (some identity (map #(pattern-in-map? % pm) input))))

(defn run [input]
  (let [pm (pattern-map input)]
    (println (part1 pm))
    (println (part2 pm input))))

