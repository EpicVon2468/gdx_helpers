package io.github.epicvon2468.gdx_helpers.actors

import com.badlogic.gdx.scenes.scene2d.Actor

import ktx.actors.centerPosition

fun Actor.centrePosition(
	width: Float = this.stage.width,
	height: Float = this.stage.height,
	normalise: Boolean = false
) = this.centerPosition(width, height, normalise)