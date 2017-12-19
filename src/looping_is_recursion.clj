(ns looping-is-recursion)

;; 1) Write the function (power n k) that computes the mathematical expression n^k
(defn power [base exp]
  (let [helper (fn [acc multiplier n] 
                (if (zero? n)
                  acc
                  (recur (* acc multiplier) multiplier (dec n))))]
    (helper 1 base exp)))

;; 2) Compute the last element of a sequence.
(defn last-element [a-seq]
  (let [helper (fn [a-seq]
                (if (= 1 (count a-seq))
                  a-seq
                  (recur (rest a-seq))))]
    (helper a-seq)))

;; 3) Write the function (seq= a-seq b-seq) that compares two sequences for equality.
(defn seq= [seq1 seq2]
  (cond
    (and (empty? seq1) (empty? seq2)) true
    (or
      (empty? seq1)
      (empty? seq2)
      (not (= (first seq1) (first seq2)))) false 
  :else (recur (rest seq1) (rest seq2))))

;; 4) Implement the function (find-first-index [predicate seq]) that returns the
;; first index in seq for which predicate returns true, or nil if no such index exists.
(defn find-first-index [pred a-seq]
  (loop [head  (first a-seq)
        remain (rest a-seq)]
    (if (= (pred head))
          (count remain) ; num items == idx of head in seq
          (if (= 0 (count remain))
            nil
            (recur (first remain) (rest remain))))))

;; 5) Implement the function (avg a-seq) that computes the average of a sequence.
(defn avg [a-seq]
  (loop [avg 0
         idx 0]
    (if (= idx (- (count a-seq) 1)) ;; is there a more elegant way?
      (/ avg (count a-seq))
      (recur (+ avg (nth a-seq idx)) (inc idx)))))

;; 6) Write the function (parity a-seq) that takes in a sequence and returns
;; a set of those elements that occur an odd number of times in the sequence.
(defn parity [a-seq]
  ":(")

(defn fast-fibo [n]
  ":(")

(defn cut-at-repetition [a-seq]
  [":("])

