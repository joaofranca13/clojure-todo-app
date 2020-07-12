(ns clojure-todo-app.components.web.routes
  (:require [io.pedestal.http :as http]
            [io.pedestal.http.body-params :as body-params]
            [clojure-todo-app.components.web.views :as views]
            [io.pedestal.http.route :as route]))


(def common-interceptors [(body-params/body-params) http/html-body])


(def routes
  #{["/" :get (conj common-interceptors 'views/home-page) :route-name :index]})


(def url-for (route/url-for-routes
               (route/expand-routes routes)))
