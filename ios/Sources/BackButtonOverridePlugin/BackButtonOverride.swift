import Foundation

@objc public class BackButtonOverride: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
