package io.github.epicvon2468.gdx_helpers.actors

import com.badlogic.gdx.scenes.scene2d.Actor

import io.github.epicvon2468.gdx_helpers.colours.Colour

import ktx.actors.centerPosition

fun Actor.centrePosition(
	width: Float = this.stage.width,
	height: Float = this.stage.height,
	normalise: Boolean = false
) = this.centerPosition(width, height, normalise)

inline var Actor.colour: Colour
	get() = this.color
	set(value) = this.setColor(value)

fun Actor.setColour(r: Float, g: Float, b: Float, a: Float) = this.setColor(r, g, b, a)