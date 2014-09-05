{:user {:dependencies [[im.chit/vinyasa "0.1.8"]
                       [difform "1.1.2"]
                       [org.clojure/tools.namespace "0.2.4"]
                       [spyscope "0.1.4"]]
        :plugins [[lein-localrepo "0.5.3"]
                  [jonase/eastwood "0.1.2"]
                  [cider/cider-nrepl "0.8.0-SNAPSHOT"]
                  [lein-exec "0.3.4"]]
        :repl-options {:init (set! *print-length* 42)}
        ;:cljsbuild {:builds {:dev {:notify-command ["growlnotify" "-m"]}}}
        :injections [(require 'vinyasa.inject 'com.georgejahad.difform 'spyscope.core)
                     (vinyasa.inject/inject 'clojure.core '>
                                            '[[clojure.repl doc source pst]
                                              [clojure.pprint pprint pp]
                                              [com.georgejahad.difform difform]
                                              [clojure.java.javadoc javadoc]
                                              [clojure.tools.namespace.repl refresh]
                                              [vinyasa.pull pull]])]}}
