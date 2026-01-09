package io.github.epicvon2468.gdx_helpers.sprites

import com.badlogic.gdx.graphics.g2d.Sprite

import io.github.epicvon2468.gdx_helpers.colours.Colour

inline var Sprite.colour: Colour
	get() = this.color
	set(value) = this.setColor(value)

fun Sprite.setColour(r: Float, g: Float, b: Float, a: Float) = this.setColor(r, g, b, a)