{:user {:dependencies [[im.chit/vinyasa "0.1.8"]
                       [difform "1.1.2"]
                       [org.clojure/tools.namespace "0.2.4"]
                       [spyscope "0.1.4"]]
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
        :injections [(require 'vinyasa.inject 'com.georgejahad.difform 'spyscope.core)
                     (vinyasa.inject/inject 'clojure.core '>
                                            '[[clojure.repl doc source pst]
                                              [clojure.pprint pprint pp]
                                              [com.georgejahad.difform difform]
                                              [clojure.java.javadoc javadoc]
                                              [clojure.tools.namespace.repl refresh]
                                              [vinyasa.pull pull]])]}}
