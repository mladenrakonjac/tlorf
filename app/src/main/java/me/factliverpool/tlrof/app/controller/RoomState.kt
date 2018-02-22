package me.factliverpool.tlrof.app.controller

/**
 * Created by mladenrakonjac on 12/12/2017.
 */
data class RoomState(
        var clock: Clock? = null,
        var curtain: Curtain? = null,
        var fragrance: String? = "",
        var glasses: Glasses? = null,
        var lights: Lights? = null,
        var printer: Printer? = null,
        var seats: Seats? = null,
        var uvlight: UvLight? = null)

data class Curtain(var command : String =" ",
                   var position : Int = 0,
                   var state: String = " ")

data class Clock(var command: String = "",
                 var state: String = "")

data class Glasses( var glass1: String = "",
                    var glass2: String = "",
                    var glass3: String = "")

data class Lights( var metadata: Metadata? = null,
                   var state: State? = null,
                   var timestamp: String? = "")

data class Metadata(var id: Int = 10,
                    var name: String = "Piano",
                    var type: String = "Extended color light")

data class State(var alert: String = "",
                    var bri: Int = 157,
                    var colormode: String = "ct",
                    var ct : Int = 366,
                    var effect: String = "none",
                    var hue : Int = 14988,
                    var mode: String = "homeautomation",
                    var on: Boolean = true,
                    var reachable : Boolean = true,
                    var sat: Int =  141,
                    var xy: XY? = null)

data class XY (var x: Double = 0.45775,
               var y: Double = 0.4101)

data class Printer( var command: String = "null",
                    var state: String = "idle")

data class Seats( var seat1: String = "",
                  var seat2: String = "",
                  var seat3: String = "")

data class UvLight(var command: String = "null",
                   var state: String = "on")




