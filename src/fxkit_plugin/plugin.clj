(ns fxkit-plugin.plugin
  (:import [javafx.application Application Platform]
           [com.sun.javafx.tk Toolkit]
           [com.sun.javafx.application PlatformImpl])
  (:use [clojure.pprint :only [pprint]])
  (:require [robert.hooke]
            [leiningen.compile]))

(defn eval-in-hook [f project form]
  (let [form (concat
               (take 1 form)
               `((com.sun.javafx.application.PlatformImpl/startup ^Runnable (fn [])))
               (drop 1 form)
               `((com.sun.javafx.application.PlatformImpl/exit)))]
    (f project form)))

(defn activate []
  (println "== activate")
  (robert.hooke/add-hook
    #'leiningen.core.eval/eval-in
    #'eval-in-hook))

(defn hooks []
  (activate))