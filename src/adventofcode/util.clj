(ns adventofcode.util)
(require '[clojure.string :as str])

(defn read-input [file, mapFn]
  (map mapFn (->> file slurp str/split-lines)))

