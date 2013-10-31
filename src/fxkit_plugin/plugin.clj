(ns fxkit-plugin.plugin
  (:import [javafx.application Application Platform]
           [com.sun.javafx.tk Toolkit]
           [com.sun.javafx.application PlatformImpl])
  (:use [clojure.pprint :only [pprint]])
  (:require [robert.hooke]
            [leiningen.compile]))

(defn eval-in-hook [f project form]
  (let [form `(try
                (com.sun.javafx.application.PlatformImpl/startup ^Runnable (fn []))
                ~form
                (catch Exception e#
                  (.printStackTrace e#))
                (finally
                  (com.sun.javafx.application.PlatformImpl/exit)))]
    (try (f project form)
      (catch Exception e))))

(defn hooks []
  (robert.hooke/add-hook
    #'leiningen.core.eval/eval-in
    #'eval-in-hook))