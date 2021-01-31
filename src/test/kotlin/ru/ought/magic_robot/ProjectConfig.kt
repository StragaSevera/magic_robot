package ru.ought.magic_robot

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.spec.IsolationMode

class ProjectConfig: AbstractProjectConfig() {
    override val isolationMode = IsolationMode.InstancePerLeaf
}