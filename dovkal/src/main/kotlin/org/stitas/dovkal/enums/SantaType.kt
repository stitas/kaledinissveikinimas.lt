package org.stitas.dovkal.enums

// avatarId and VOICE_ID are constants retrieved from HeyGen
enum class SantaType(
    val avatarId: String
) {
    CLASSIC("ef4f6bf833954a1d9a9fe7a910d2d787"),
    CHIMNEY("17da61957c8e42d7bf246ff01f27159c"),
    SLEIGH("d5cfb9352abd43ce8de5e6c52421315b");

    companion object {
        const val VOICE_ID = "821a0368c5ed49b7bb09e11d7a323d43"
    }
}