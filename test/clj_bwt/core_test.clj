(ns clj-bwt.core-test
  (:require [clojure.test :refer :all]
            [clj-bwt.core :refer :all]))

(deftest rotations-test
  (is (= (rotations [1 2 3]) '((1 2 3) (2 3 1) (3 1 2)))))

(deftest bwt-test
  (is (= (bwt "The rain in Spain stays mainly in the plain")
         "nnyseennn $rplmthhtT aa aapn iiiiiiS  y s la")))

(deftest reverse-bwt-test
  (is (= (reverse-bwt (bwt "The rain in Spain stays mainly in the plain"))
         "The rain in Spain stays mainly in the plain")))
