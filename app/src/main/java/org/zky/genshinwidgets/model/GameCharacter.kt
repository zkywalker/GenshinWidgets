package org.zky.genshinwidgets.model


data class GameCharacter(
    val id: Int,
    val image: String,
    val icon: String,
    val name: String,
    val element: String,
    val fetter: Int,
    val level: Int,
    val rarity: Int,
    val actived_constellation_num: Int,
)

//{
//  "id": 10000002,
//  "image": "https://upload-bbs.mihoyo.com/game_record/genshin/character_image/UI_AvatarIcon_Ayaka@2x.png",
//  "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/character_icon/UI_AvatarIcon_Ayaka.png",
//  "name": "神里绫华",
//  "element": "Cryo",
//  "fetter": 10,
//  "level": 90,
//  "rarity": 5,
//  "weapon": {
//    "id": 11414,
//    "name": "天目影打刀",
//    "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_EquipIcon_Sword_Bakufu.png",
//    "type": 1,
//    "rarity": 4,
//    "level": 90,
//    "promote_level": 6,
//    "type_name": "单手剑",
//    "desc": "传说中连以神速见长的天狗都能斩落的名士订制的刀。",
//    "affix_level": 5
//  },
//  "reliquaries": [
//    {
//      "id": 71543,
//      "name": "历经风雪的思念",
//      "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_14001_4.png",
//      "pos": 1,
//      "rarity": 5,
//      "level": 20,
//      "set": {
//        "id": 2140011,
//        "name": "冰风迷途的勇士",
//        "affixes": [
//          {
//            "activation_number": 2,
//            "effect": "获得15%冰元素伤害加成。"
//          },
//          {
//            "activation_number": 4,
//            "effect": "攻击处于冰元素影响下的敌人时，暴击率提高20%；若敌人处于冻结状态下，则暴击率额外提高20%。"
//          }
//        ]
//      },
//      "pos_name": "生之花"
//    },
//    {
//      "id": 71523,
//      "name": "摧冰而行的执望",
//      "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_14001_2.png",
//      "pos": 2,
//      "rarity": 5,
//      "level": 20,
//      "set": {
//        "id": 2140011,
//        "name": "冰风迷途的勇士",
//        "affixes": [
//          {
//            "activation_number": 2,
//            "effect": "获得15%冰元素伤害加成。"
//          },
//          {
//            "activation_number": 4,
//            "effect": "攻击处于冰元素影响下的敌人时，暴击率提高20%；若敌人处于冻结状态下，则暴击率额外提高20%。"
//          }
//        ]
//      },
//      "pos_name": "死之羽"
//    },
//    {
//      "id": 71553,
//      "name": "冰雪故园的终期",
//      "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_14001_5.png",
//      "pos": 3,
//      "rarity": 5,
//      "level": 20,
//      "set": {
//        "id": 2140011,
//        "name": "冰风迷途的勇士",
//        "affixes": [
//          {
//            "activation_number": 2,
//            "effect": "获得15%冰元素伤害加成。"
//          },
//          {
//            "activation_number": 4,
//            "effect": "攻击处于冰元素影响下的敌人时，暴击率提高20%；若敌人处于冻结状态下，则暴击率额外提高20%。"
//          }
//        ]
//      },
//      "pos_name": "时之沙"
//    },
//    {
//      "id": 90514,
//      "name": "沉波之盏",
//      "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_15016_1.png",
//      "pos": 4,
//      "rarity": 5,
//      "level": 20,
//      "set": {
//        "id": 2150161,
//        "name": "沉沦之心",
//        "affixes": [
//          {
//            "activation_number": 2,
//            "effect": "获得15%水元素伤害加成。"
//          },
//          {
//            "activation_number": 4,
//            "effect": "施放元素战技后的15秒内，普通攻击与重击造成的伤害提高30%。"
//          }
//        ]
//      },
//      "pos_name": "空之杯"
//    },
//    {
//      "id": 71533,
//      "name": "破冰踏雪的回音",
//      "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/equip/UI_RelicIcon_14001_3.png",
//      "pos": 5,
//      "rarity": 5,
//      "level": 20,
//      "set": {
//        "id": 2140011,
//        "name": "冰风迷途的勇士",
//        "affixes": [
//          {
//            "activation_number": 2,
//            "effect": "获得15%冰元素伤害加成。"
//          },
//          {
//            "activation_number": 4,
//            "effect": "攻击处于冰元素影响下的敌人时，暴击率提高20%；若敌人处于冻结状态下，则暴击率额外提高20%。"
//          }
//        ]
//      },
//      "pos_name": "理之冠"
//    }
//  ],
//  "constellations": [
//    {
//      "id": 21,
//      "name": "霜杀墨染樱",
//      "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Ayaka_01.png",
//      "effect": "神里绫华的普通攻击或重击对敌人造成<color=#99FFFFFF>冰元素伤害</color>时，有50%的几率使<color=#FFD780FF>神里流·冰华</color>的冷却时间缩减0.3秒。该效果每0.1秒只能触发一次。",
//      "is_actived": false,
//      "pos": 1
//    },
//    {
//      "id": 22,
//      "name": "三重雪关扉",
//      "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Ayaka_02.png",
//      "effect": "施放<color=#FFD780FF>神里流·霜灭</color>时，会额外释放两股规模较小的霜见雪关扉，各自能造成原本20%的伤害。",
//      "is_actived": false,
//      "pos": 2
//    },
//    {
//      "id": 23,
//      "name": "花白锦画纸吹雪",
//      "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Ayaka_02.png",
//      "effect": "<color=#FFD780FF>神里流·霜灭</color>的技能等级提高3级。\\n至多提升至15级。",
//      "is_actived": false,
//      "pos": 3
//    },
//    {
//      "id": 24,
//      "name": "盈缺流返",
//      "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Ayaka_03.png",
//      "effect": "敌人受到<color=#FFD780FF>神里流·霜灭</color>的霜见雪关扉造成的伤害后，防御力降低30%，持续6秒。",
//      "is_actived": false,
//      "pos": 4
//    },
//    {
//      "id": 25,
//      "name": "花云钟入月",
//      "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_U_Ayaka_01.png",
//      "effect": "<color=#FFD780FF>神里流·冰华</color>的技能等级提高3级。\\n至多提升至15级。",
//      "is_actived": false,
//      "pos": 5
//    },
//    {
//      "id": 26,
//      "name": "间水月",
//      "icon": "https://upload-bbs.mihoyo.com/game_record/genshin/constellation_icon/UI_Talent_S_Ayaka_04.png",
//      "effect": "每过10秒，神里绫华会获得「薄冰舞踏」，使重击造成的伤害提高298%。薄冰舞踏效果将在重击命中敌人的0.5秒后清除，并重新开始计算时间。",
//      "is_actived": false,
//      "pos": 6
//    }
//  ],
//  "actived_constellation_num": 0,
//  "costumes": [],
//  "external": null
//}
