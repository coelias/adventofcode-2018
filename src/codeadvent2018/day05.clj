(ns codeadvent2018.day05)

(defn react? [c1 c2]
  (and
   (not= c1 c2)
   (= (clojure.string/lower-case c1)
      (clojure.string/lower-case c2))))

(defn part1 [input]
  (loop [acc [] input (vec input)]
    (if (empty? input)
      (count acc)
      (if (some-> (peek acc) (react? (first input)))
        (recur (pop acc) (rest input))
        (recur (conj acc (first input)) (rest input))))))

(defn run [input]
  (println (part1 (first input))))
