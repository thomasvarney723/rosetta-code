;; rosettacode.org "Anagrams"

;; Using the word list at http://www.puzzlers.org/pub/wordlists/unixdict.txt, 
;; find the sets of words that share the same characters that contain the most 
;; words in them.

(->> (slurp "http://www.puzzlers.org/pub/wordlists/unixdict.txt")
     clojure.string/split-lines
     (group-by sort)
     vals
     (sort-by count >)  ;; sort in reverse
     (partition-by count)
     first)

;; (["caret" "carte" "cater" "crate" "trace"] 
;;  ["angel" "angle" "galen" "glean" "lange"] 
;;  ["elan" "lane" "lean" "lena" "neal"] 
;;  ["alger" "glare" "lager" "large" "regal"] 
;;  ["evil" "levi" "live" "veil" "vile"] 
;;  ["abel" "able" "bale" "bela" "elba"])
