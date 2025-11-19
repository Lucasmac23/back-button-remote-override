// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "BackButtonRemoteOverride",
    platforms: [.iOS(.v14)],
    products: [
        .library(
            name: "BackButtonRemoteOverride",
            targets: ["BackButtonOverridePlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", from: "7.0.0")
    ],
    targets: [
        .target(
            name: "BackButtonOverridePlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/BackButtonOverridePlugin"),
        .testTarget(
            name: "BackButtonOverridePluginTests",
            dependencies: ["BackButtonOverridePlugin"],
            path: "ios/Tests/BackButtonOverridePluginTests")
    ]
)