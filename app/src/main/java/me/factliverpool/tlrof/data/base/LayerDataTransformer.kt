package me.factliverpool.tlrof.data.base

/**
 * Created by mladenrakonjac on 30/09/16.
 */

interface LayerDataTransformer<F, T> {
    fun transform(from: F): T
    fun transform(from: ArrayList<F>): ArrayList<T>
}
