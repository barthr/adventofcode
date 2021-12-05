(ns adventofcode.day3)

(require '[clojure.string :as str])
(require '[adventofcode.util :as util])

; https://adventofcode.com/2021/day/3#part1

(def input (util/read-input "resources/day3.txt" #(str/split % #"")))

(defn zipped [input] (apply map vector input))

(defn significant-digit [list condition]
  (if
    (condition
      (count (filter #(= "0" %) list))
      (count (filter #(= "1" %) list))
      ) "0" "1")
  )

(defn significant-digits [condition]
  (map #(significant-digit % condition) (zipped input)))

(defn convert-to-decimal [input] (Integer/parseInt (str/join "" input) 2))

(def gamma-rate (convert-to-decimal (significant-digits >)))
(def epsilon-rate (convert-to-decimal (significant-digits <)))

; solution part 1
(println (* gamma-rate epsilon-rate))

; solution part 2

; https://adventofcode.com/2021/day/3#part2

(defn filter-diagnostic-report [list condition index]
  (filter #(= (significant-digit (nth (zipped list) index) condition) (nth % index)) list))

(defn solution [list condition index]
  (if (> (count list) 1)
    (solution (filter-diagnostic-report list condition index) condition (+ index 1))
    (first list)
    )
  )

(def oxygen (convert-to-decimal (solution input > 0)))
(def co2 (convert-to-decimal (solution input <= 0)))

(println (* oxygen co2))

