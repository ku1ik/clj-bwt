(ns clj-bwt.core)

(defn rotations [coll]
  "Returns all rotations of the given collection"
  (map #(lazy-cat (drop % coll) (take % coll)) (range (count coll))))

(defn bwt [text eof-char]
  "Returns Burrows-Wheeler transform of the given string"
  (let [input (str text eof-char)]
    (->> input
         rotations
         (map vec)
         sort
         (map last)
         (apply str))))

(defn reverse-bwt [text eof-char]
  "Returns reverse Burrows-Wheeler transform of the given (transformed) string"
  (let [nils (repeat nil)
        reduced (reduce (fn [table _] (sort (map vector text table))) nils text)]
    (->> reduced
         (map flatten)
         (map #(remove nil? %))
         (filter #(= eof-char (last %)))
         first
         drop-last
         (apply str))))
