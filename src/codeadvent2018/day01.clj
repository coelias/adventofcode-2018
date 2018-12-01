(ns codeadvent2018.day01)

;; Arithmetic functions in clojure accept a random amount of parameters,
;; So for example:
;;     (+ 1 2)       => 3
;;     (+ 1 2 3 4)   => 10
;;     (- 1 2 3 4)   => -8  == 1 - 2 - 3 - 4
;;     (- 1 -1 1 -1) => 2   == 1 -(-1) - 1 -(-1)
;;     (* 10 5 3)    => 750
;;     (< 1 3 5 8 9) => True
;;     (< 1 3 2 8 9) => False

;; We can add all the numbers by destructuring with apply
;; the sequence of numbers

;; Apply works by destructuring the numbers of a sequence and passing them
;; as arguments to a functions, eg:
;;     (apply + [1 2 3])             => (+ 1 2 3)              => 6
;;     (apply str ["hello" "world"]) => (str "hello" "world")  => "helloworld"

(defn calibration1 [numbers]
  (apply + numbers))

(defn calibration2 [numbers]
  (loop [freqs (reductions + (cycle numbers))
         found #{}]
    (let [[freq & freqs] freqs]
      (if (get found freq)
        freq
        (recur freqs (conj found freq))))))

(defn run [input]
  (let [numbers (map #(Integer/parseInt %) input)]
    (println (calibration1 numbers))
    (println (calibration2 numbers))))
