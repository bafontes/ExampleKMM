import SwiftUI
import shared

struct Product: Identifiable{
    var id: Int
    let name: String
}

struct ContentView: View {
    @ObservedObject private(set) var viewModel: ViewModel
    @State var searchText: String  = ""
    var body: some View {
        VStack {
            Text("Mercado Libre")
                .font(.system(size: 40, weight: .bold, design: .rounded))
                .padding(.bottom, 40)

            SearchbarView(text: $searchText).padding(.top, -30)
            List(viewModel.products) { product in
                HStack {
                    Text(product.name)
                }
            }
        }

    }
}

extension ContentView {
    class ViewModel: ObservableObject {
        var products: [Product] = [.init(id: 1, name: "hola"), .init(id: 2, name: "como"), .init(id: 3, name: "estas")]
        init() {


//            Greeting().greeting { greeting, error in
//                DispatchQueue.main.async {
//                    if let greeting = greeting {
//                        self.text = greeting
//                    } else {
//                        self.text = error?.localizedDescription ?? "error"
//                    }
//                }
//            }
        }
    }
}
struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView(viewModel: ContentView.ViewModel())
            .previewDevice(PreviewDevice(rawValue: "iPhone 14"))
            .previewDisplayName("iPhone 14")
    }
}
