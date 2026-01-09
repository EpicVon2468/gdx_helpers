package io.github.epicvon2468.gdx_helpers.disposables

import ktx.assets.DisposableRegistry

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.utils.Disposable

/**
 * Annotation used to conveniently inform developers that a [Disposable] resource should **NOT** be disposed manually.
 *
 * Reasons for this may vary, so the [Reason] enum is provided to help clarify the underlying cause.
 */
@Retention(AnnotationRetention.SOURCE) // No need to clog binary size.
annotation class DoNotManuallyDispose(val reason: Reason) {

	enum class Reason {
		/**
		 * Disposing this resource manually may have unintended consequences on other resources or systems.
		 * Usually this applies to only [Skin] instances, as they will attempt to dispose any [Disposable] objects within, even if ownership is not guaranteed.
		 */
		UNINTENDED_BEHAVIOUR,
		/**
		 * The annotated resource is managed via external means, such as [DisposableRegistry] or [AssetManager].
		 */
		MANAGED_RESOURCE,
		/**
		 * Unknown or other reason.
		 */
		OTHER
	}
}