{:user {:dependencies [[spyscope "0.1.4"]
                       [org.clojure/tools.namespace "0.2.4"]
                       [im.chit/vinyasa "0.2.2"]
                       [im.chit/iroh "0.1.11"]
                       [io.aviso/pretty "0.1.8"]
                       [leiningen #=(leiningen.core.main/leiningen-version)]
                       [difform "1.1.2"]]
        :plugins [[lein-localrepo "0.5.3"]
                  [jonase/eastwood "0.1.4"]
                  [cider/cider-nrepl "0.8.0-SNAPSHOT"]
                  [lein-exec "0.3.4"]]
        :repl-options {:init (set! *print-length* 42)
                       :nrepl-middleware
                       [cider.nrepl.middleware.classpath/wrap-classpath
                        cider.nrepl.middleware.complete/wrap-complete
                        cider.nrepl.middleware.info/wrap-info
                        cider.nrepl.middleware.inspect/wrap-inspect
                        cider.nrepl.middleware.macroexpand/wrap-macroexpand
                        cider.nrepl.middleware.resource/wrap-resource
                        cider.nrepl.middleware.stacktrace/wrap-stacktrace
                        cider.nrepl.middleware.test/wrap-test
                        cider.nrepl.middleware.trace/wrap-trace
                        cider.nrepl.middleware.undef/wrap-undef]}
        ;:cljsbuild {:builds {:dev {:notify-command ["growlnotify" "-m"]}}}
        :injections [(require 'com.georgejahad.difform)
                     (require 'spyscope.core)
                     (require '[vinyasa.inject :as inject])
                     (require 'io.aviso.repl)
                     (inject/in
                      [vinyasa.inject :refer [inject [in inject-in]]]
                      [vinyasa.lein :exclude [*project*]]
                      [vinyasa.pull :all]
                      [cemerick.pomegranate add-classpath get-classpath resources]
                      clojure.core
                      [iroh.core .> .? .* .% .%>]
                      clojure.core >
                      [clojure.pprint pprint]
                      [clojure.java.shell sh])]}}
