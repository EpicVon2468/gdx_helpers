package io.github.epicvon2468.gdx_helpers.actors

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.scenes.scene2d.Actor

import io.github.epicvon2468.gdx_helpers.colours.Colour
import io.github.epicvon2468.gdx_helpers.sprites.colour

import org.jetbrains.annotations.ApiStatus
import org.jetbrains.annotations.MustBeInvokedByOverriders

interface SpriteRenderable {

	@get:ApiStatus.Internal
	val sprite: Sprite

	@MustBeInvokedByOverriders
	fun draw(batch: Batch, parentAlpha: Float) = this.sprite.draw(batch, parentAlpha)
}

open class SpriteActor(
	@ApiStatus.Internal
	override val sprite: Sprite
) : Actor(), SpriteRenderable {

	constructor(texture: Texture) : this(Sprite(texture))

	override fun debug(): SpriteActor {
		super.debug()
		return this
	}

	init {
		this.setBounds(this.x, this.y, this.sprite.width, this.sprite.height)
		this.setScale(this.sprite.scaleX, this.sprite.scaleY)
		this.rotation = this.sprite.rotation
	}

	override fun setColor(colour: Colour) {
		super.setColor(colour)
		this.colourChanged()
	}

	override fun setColor(r: Float, g: Float, b: Float, a: Float) {
		super.setColor(r, g, b, a)
		this.colourChanged()
	}

	open fun colourChanged() {
		val colour = this.colour
		if (this.sprite.colour != colour) this.sprite.colour = colour
	}

	override fun positionChanged() {
		val x: Float = this.x
		val y: Float = this.y
		if (this.sprite.x != x || this.sprite.y != y) this.sprite.setPosition(x, y)
	}
	override fun sizeChanged() {
		val width: Float = this.width
		val height: Float = this.height
		if (this.sprite.width != width || this.sprite.height != height) this.sprite.setSize(width, height)
	}
	override fun scaleChanged() {
		val scaleX: Float = this.scaleX
		val scaleY: Float = this.scaleY
		if (this.sprite.scaleX != scaleX || this.sprite.scaleY != scaleY) this.sprite.setScale(scaleX, scaleY)
	}
	override fun rotationChanged() {
		val rotation: Float = this.rotation
		if (this.sprite.rotation != rotation) this.sprite.rotation = rotation
	}

	override fun draw(batch: Batch, parentAlpha: Float) = super<SpriteRenderable>.draw(batch, parentAlpha)
}