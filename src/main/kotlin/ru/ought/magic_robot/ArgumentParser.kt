package ru.ought.magic_robot

// Returns a map of parameters and their arguments. Arguments without parameters are under a key ""
// Uses full immutability, therefore is not efficient
fun parseArgs(args: Array<String>): Map<String, List<String>> =
    args.fold<String, Pair<Map<String, List<String>>, String>>(
        Pair(emptyMap(), "")
    ) { (map, lastParameter), elem ->
        if (elem.startsWith("-")) // This token is a parameter
            Pair(map + (elem to emptyList()), elem) // Add this parameter with empty args
        else // This token is an argument
        // Add this argument to previous parameter
            Pair(map + (lastParameter to map.getOrDefault(lastParameter, emptyList()) + elem),
                lastParameter)
    }.first