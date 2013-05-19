-- _ = require "underscore" -- Load the underscore.lua library
require "Game" -- Load the Game library

print("Running " .. Game.name .. " v" .. Game.version .. " (script.lua)")

Game.sound.muteSound()

function keyPressed(key, char)
    if (key == Game.input.KEY_A) then
        Game.error("Oh noes!", "Something went wrong.. This is called from the lua file!")
    end

    print("Pressed key: " .. key .. ", " .. char)
end