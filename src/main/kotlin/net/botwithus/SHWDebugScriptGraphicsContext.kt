package net.botwithus

import net.botwithus.rs3.imgui.ImGui
import net.botwithus.rs3.imgui.ImGuiWindowFlag
import net.botwithus.rs3.script.ScriptConsole
import net.botwithus.rs3.script.ScriptGraphicsContext

class SHWDebugScriptGraphicsContext(
		private val script: SWHDebugScript,
		console: ScriptConsole
): ScriptGraphicsContext(console) {

	override fun drawSettings() {
		super.drawSettings()
		if (ImGui.Begin("My script", ImGuiWindowFlag.None.value)) {
			if (ImGui.BeginTabBar("My bar", ImGuiWindowFlag.None.value)) {
				if (ImGui.BeginTabItem("Settings", ImGuiWindowFlag.None.value)) {
					ImGui.Text("Welcome to my script!")
					ImGui.Text("My scripts state is: " + script.botState)
					ImGui.EndTabItem()
				}
				if (script.botState == SWHDebugScript.BotState.IDLE) {
					if (ImGui.Button("Run")) {
						script.botState = SWHDebugScript.BotState.RUNNING
					}
				} else {
					if (ImGui.Button("Stop")) {
						script.botState = SWHDebugScript.BotState.IDLE
					}
				}
				ImGui.EndTabBar()

			}
			ImGui.End()
		}
	}

	override fun drawOverlay() {
		super.drawOverlay()
	}

}