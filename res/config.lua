-- Don't use 'local' for config stuff
-- Functions go at the TOP

-- _ = require "underscore" -- Load the underscore.lua library
require "Game" -- Load the Game library

print("Running " .. Game.name .. " v" .. Game.version .. " (config.lua)")

test = math.random(1, 100)

-- item_tooltipOpacity = 0.65 -- opacity of the item tooltip on the ground
font = "Fontin"