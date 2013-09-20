//For more information about configuration go to: https://bitbucket.org/tednaleid/grails-jasypt/wiki/Home
jasypt {
    algorithm = "PBEWITHSHA256AND256BITAES-CBC-BC"
    providerName = "BC"
    password = "passphrase"
    keyObtentionIterations = 1000
}