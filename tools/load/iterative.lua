counter = 0
longitude = 0
latitude = 0
currentDate = 0


init = function(args)
   currentDate = args[1]
   longitude = args[2]
   latitude = args[3]
end

request = function()
   wrk.method = "GET"
   counter = counter + 1
   wrk.headers["userId"] = counter
   wrk.headers["longitude"] = longitude
   wrk.headers["latitude"] = latitude
   path = "/hub/cards?currentDate=" .. currentDate
   return wrk.format(nil, path)
end