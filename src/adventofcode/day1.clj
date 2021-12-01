; https://adventofcode.com/2021/day/1
(ns adventofcode.day1)
(require '[clojure.string :as str])

(defn max-sequence [input]
  (reduce
    (fn [res [current, next]]
      (+ res (if (> next current) 1 0)))
    0
    (partition 2 1 input)))

(defn read-input []
  (->> "resources/day1.txt" slurp str/split-lines (map #(Integer/parseInt %))))