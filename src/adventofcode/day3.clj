(ns adventofcode.day3)

(require '[clojure.string :as str])
(require '[adventofcode.util :as util])

; https://adventofcode.com/2021/day/3#part1

(def input (util/read-input "resources/day3.txt" #(str/split % #"")))

(def zipped (apply map vector input))

(defn significant-digit [condition]
  (
    map
    #(if
       (condition
         (count (filter (fn [v] (= "0" v)) %))
         (count (filter (fn [v] (= "1" v)) %))
         ) 0 1)
    zipped
    )
  )

(def gamma-rate (Integer/parseInt (str/join "" (significant-digit >)) 2))
(def epsilon-rate (Integer/parseInt (str/join "" (significant-digit <)) 2))

; solution part 1
(println (* gamma-rate epsilon-rate))

; solution part 2

