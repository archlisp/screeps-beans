(ns screeps.spawn
  (:refer-clojure :exclude [name]))

(defn name
  [s]
  (.-name s))

(defn room
  [s]
  (.-room s))

(defn create-creep
  [sp body memory]
  (.createCreep sp (clj->js body) nil (clj->js memory)))
