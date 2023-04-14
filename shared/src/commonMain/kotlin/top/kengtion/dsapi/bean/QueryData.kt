package top.kengtion.dsapi.bean

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class QueryData(
    @SerialName("SYNO.AudioPlayer.Stream")
    val audioStream:CommonQueryData,
    @SerialName("SYNO.AudioStation.Album")
    val album:CommonQueryData,
    @SerialName("SYNO.AudioStation.Artist")
    val artist:CommonQueryData,
    @SerialName("SYNO.AudioStation.Cover")
    val cover:CommonQueryData,
    @SerialName("SYNO.AudioStation.Browse.Playlist")
    val playList:CommonQueryData,
)