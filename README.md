# Piston and Observer

This mod backports sticky blocks (slime/honey) and observers to 1.7.10.

**note: working on an update to use mixins. Currently won't build**

## Dependencies
**TODO: put links here**
- [unimixin]
- [GTNH Lib]
- [LibPiston]

## Piston Features
Piston behavior is modified so that blocks that are stuck to sticky blocks will be moved
together. You can configure if vanilla pistons are changed to this, or the behavior is added
to new piston and sticky piston blocks.

What are "sticky blocks"? This mod provides a slime block implementation and a honey block one
to mimic vanilla behavior. By default, they are only added if no compatible mods are detected.

Compatible mods include:
- Tinker's Construct's green and blue congealed slime blocks (green and blue don't stick to each other)
- Biomes O Plenty's honey block

You can also add more to the config, and also config what will not stick to what.

By default, piston features have no recipes. Use other mods to add recipes.

## Observer Features
Observers are not TileEntities (anymore). They are movable by pistons and can be used to create flying machines.

What works by default without individual tweaks (non-exhaustive):
- Flying machine
- Clock (by having 2 observers face-to-face)
- Place potion on Brewing Stand
- Placing flower in flower pot

Some tweaks to vanilla blocks are needed to have their state changes detected by observers like
in later versions. Every such modification has a config that you can turn off if it causes conflicts
with other mods.

**What doesn't work yet**
- Iron Door open/close (upper)
- Snow on grass
- Note/instrument/powered state change for Note Blocks
- Locked state changes for powered Repeaters

## Observer API
This mod provides an API for other mods to integrate into the observer system:

- `ObserverAPI` to notify observers in the world of some change
- `IBlockObservable` for blocks to override how they notify observers
  - for example, observers notify themselves when moved by pistons
  - you can also make a block only notify observers in a certain direction
- `IBlockObserver` for blocks to become an observer
  
## Contribution
Contributions are welcome. Feel free to open issues/PRs if there is a bug or observer feature missing.

## Dev Setup
**TODO: actual steps**
I use [mcmod](https://github.com/Pistonight/mcmod) to run commands
