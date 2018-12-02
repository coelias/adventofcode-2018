(ns codeadvent2018.day02)

(defn part1 [strings]
  (reduce
   (partial merge-with +)
   (map
    #(-> %
         frequencies
         vals
         set
         frequencies)
    strings)))

(defn get-equals [s1 s2]
  (let [equals (filter (fn [[s1 s2]] (= s1 s2)) (map vector s1 s2))]
    (apply str (map first equals))))

(defn part2 [strings]
  (first (for [x strings y strings
               :let [common-chars (get-equals x y)]
               :when (= (count x) (inc (count common-chars)))]
           common-chars)))

(defn run [input]
  (let [p1 (part1 input)
        p2 (part2 input)]
    (println (* (get p1 2 1) (get p1 3 1)))
    (println p2)))
