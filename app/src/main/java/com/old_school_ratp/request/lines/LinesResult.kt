package com.old_school_ratp.request.lines

import com.old_school_ratp.request.transport.*

class LinesResult {
    val metros: List<Metro?> = emptyList()
    val rers: List<RER?> = emptyList()
    val tramways: List<Tram?> = emptyList()
    val buses: List<Bus?> = emptyList()
    val noctiliens: List<Noctilien?> = emptyList()
}