(ns adventofcode.day2)

(require '[clojure.string :as str])
(require '[adventofcode.util :as util])

; https://adventofcode.com/2021/day/2

(def day2 (util/read-input "resources/day2.txt" #(str/split % #" ")))

(defn parse-actions [value]
  (vector (first value) (Integer/parseInt (second value))))

(def actions
  (map parse-actions day2))

; part 1

(def solution
  (reduce
    (fn [res [action value]]
      (case action
        "forward" (update res :position + value)
        "down" (update res :depth + value)
        "up" (update res :depth - value)
        res
        )
      )
    {:position 0 :depth 0} actions
    )
  )

(println (* (get solution :position) (get solution :depth)))

; part 2

(def solution2
  (reduce
    (fn [res [action value]]
      (case action
        "forward" (update (update res :position + value) :depth + (* value (get res :aim)))
        "down" (update res :aim + value)
        "up" (update res :aim - value)
        res
        )
      )
    {:position 0 :depth 0 :aim 0} actions
    )
  )

(println (* (get solution2 :position) (get solution2 :depth)))








