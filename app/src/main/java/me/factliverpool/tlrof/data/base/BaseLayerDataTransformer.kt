package me.factliverpool.tlrof.data.base

/**
 * Created by mladenrakonjac on 30/09/16.
 */

abstract class BaseLayerDataTransformer<F, T : Any> : LayerDataTransformer<F, T> {

    override fun transform(from: ArrayList<F>): ArrayList<T> {
        val transformed = ArrayList<T>(from.size)

        from.mapNotNullTo(transformed) { transform(it) }

        return transformed
    }
}