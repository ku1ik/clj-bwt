# clj-bwt

A Clojure library for doing Burrows–Wheeler transform (and reverse B-W transform).

## Usage

```clojure
(ns com.example
  (:require [clj-bwt.core :refer [bwt reverse-bwt]]))
  
(bwt "The rain in Spain stays mainly in the plain" \$)
; => "nnyseennn $rplmthhtT aa aapn iiiiiiS  y s la"

(reverse-bwt "nnyseennn $rplmthhtT aa aapn iiiiiiS  y s la" \$)
; => "The rain in Spain stays mainly in the plain"

```

## License

Copyright © 2014-2016 Marcin Kulik

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
